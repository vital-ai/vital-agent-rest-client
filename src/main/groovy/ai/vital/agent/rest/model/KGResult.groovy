package ai.vital.agent.rest.model

import ai.vital.vitalsigns.json.JSONSerializer
import ai.vital.vitalsigns.model.GraphObject

class KGResult extends BaseModelObject{

    String model_class = "KGResult"

    double object_score = 1.0

    String object_json = null

    public setGraphObject(GraphObject object, double score = 1.0) {

        this.object_json = object.toJSON()
        this.object_score = score
    }

    public GraphObject getGraphObject() {

        try {
            GraphObject go = JSONSerializer.fromJSONString(object_json)

            return go
        }
        catch(Exception ignored) {

            // TODO handle parse exception
        }

        return null

    }

    public double getGraphObjectScore() {

        return object_score

    }

    static {
        registerType("KGResult", KGResult)
    }

}
