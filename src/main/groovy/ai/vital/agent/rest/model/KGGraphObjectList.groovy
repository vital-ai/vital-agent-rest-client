package ai.vital.agent.rest.model

import ai.vital.vitalsigns.json.JSONSerializer
import ai.vital.vitalsigns.model.GraphObject
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

class KGGraphObjectList extends BaseModelObject{

    // used for default map constructor
    KGGraphObjectList() {}

    KGGraphObjectList( List<GraphObject> graphObjects) {

        this.setGraphObjectList(graphObjects)
    }

    String model_class = "KGGraphObjectList"

    private String graph_object_list_json = ""

    static {
        registerType("KGGraphObjectList", KGGraphObjectList)
    }

    private transient List<Map> graphObjectListMaps = []

    private transient List<GraphObject> vitalGraphObjectList = []

    void setGraphObjectList(List<GraphObject> graphObjects) {

        vitalGraphObjectList = graphObjects

        def slurper = new JsonSlurper()

        graphObjectListMaps = graphObjects.collect { obj ->
            if (obj instanceof Map) {
                (Map)obj
            } else {
                slurper.parseText(obj.toJSON().toString()) as Map
            }
        }

        graph_object_list_json = JsonOutput.toJson(graphObjectListMaps)
    }

    List<Map> getGraphObjectList() {

        if (graph_object_list_json == null || graph_object_list_json == "") {
            return []
        }

        if (graphObjectListMaps.size() > 0) {
            return graphObjectListMaps
        }

        def slurper = new JsonSlurper()

        def graphObjects = getVitalGraphObjectList()

        graphObjectListMaps = graphObjects.collect { obj ->
            if (obj instanceof Map) {
                (Map)obj
            } else {
                slurper.parseText(obj.toJSON().toString()) as Map
            }
        }

         return graphObjectListMaps
    }

    List<GraphObject> getVitalGraphObjectList() {

        if (graph_object_list_json == null || graph_object_list_json == "") {
            return []
        }

        if (vitalGraphObjectList.size() > 0) {
            return vitalGraphObjectList
        }

        try {

            List<GraphObject> go_list = JSONSerializer.fromJSONArrayString(graph_object_list_json)

            vitalGraphObjectList = go_list

            return go_list

        } catch(Exception ignored) {

            // TODO handle parse error
        }

        return []
    }

    String getGraphObjectListJson() {
        return graph_object_list_json
    }

    @Override
    String toJson(boolean pretty=false) {

        // selecting just the serialized string for serialization

        def out = [
                model_class    : model_class,
                graph_object_list_json: graph_object_list_json
        ]

        return JsonOutput.toJson(out)
    }
}