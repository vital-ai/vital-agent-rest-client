package ai.vital.agent.rest.model

class KGResultList extends BaseModelObject{

    String model_class = "KGResultList"

    List<KGResult> result_list = []

    static {
        registerType("KGResultList", KGResultList)
    }
}
