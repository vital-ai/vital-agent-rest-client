package ai.vital.agent.rest.model

class KGGet extends KGRequest {

    String model_class = "KGGet"

    KGURIList get_uri_list = new KGURIList()

    String segment_name = null

    static {
        registerType("KGGet", KGGet)
    }


}
