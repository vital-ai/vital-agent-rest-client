package ai.vital.agent.rest.model

class KGRequest extends BaseModelObject{

    String model_class = "KGRequest"

    String account_id = null
    String login_id = null

    String jwt_string = null

    static {
        registerType("KGRequest", KGRequest)
    }

}