package ai.vital.agent.rest.model

class KGUpdate extends KGRequest {

    String model_class = "KGUpdate"

    KGUpdateType update_type = KGUpdateType.NONE

    KGGraphObjectList update_object_list = new KGGraphObjectList()

    KGURIList update_delete_uri_list = new KGURIList()

    String segment_name = null

    static {
        registerType("KGUpdate", KGUpdate)
    }

}
