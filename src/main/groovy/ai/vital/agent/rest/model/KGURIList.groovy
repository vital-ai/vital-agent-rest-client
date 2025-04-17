package ai.vital.agent.rest.model

class KGURIList extends BaseModelObject {

    String model_class = "KGURIList"

    List<String> uri_list = []

    static {
        registerType("KGURIList", KGURIList)
    }

}
