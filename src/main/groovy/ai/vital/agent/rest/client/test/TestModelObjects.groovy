package ai.vital.agent.rest.client.test

import ai.vital.agent.rest.model.BaseModelObject
import ai.vital.agent.rest.model.KGGraphObjectList
import ai.vital.vitalsigns.model.VITAL_Node

class TestModelObjects {

    static def main(args) {

        println "TestModelObjects"

        String query_incoming = '''{
  "model_class":"KGQuery",
  "kgservice_query":"SELECT * WHERE { ?s ?p ?o }",
 
}'''

        def q = BaseModelObject.fromJson(query_incoming)

        println q

        String reply = q.toJson(true)

        println reply

        String update_incoming = '''{
  "model_class":"KGUpdate" 
}'''

        def u = BaseModelObject.fromJson(update_incoming)

        println u

        reply = u.toJson(true)

        println reply

        String response_incoming = '''{
  "model_class":"KGResponse" 
}'''

        def r = BaseModelObject.fromJson(response_incoming)

        println r

        reply = r.toJson(true)

        println reply

        VITAL_Node node = new VITAL_Node()

        node.URI = "urn:123"

        node.name = "Hello"

        KGGraphObjectList obj_list = new KGGraphObjectList([node])

        def obj_list_str = obj_list.toJson()

        println "Orig:" + obj_list_str

        KGGraphObjectList obj_list_converted = (KGGraphObjectList) BaseModelObject.fromJson(obj_list_str)

        println "Converted: " + obj_list_converted

        for (go in obj_list_converted.getVitalGraphObjectList())

            println go.toJSON()
    }
}
