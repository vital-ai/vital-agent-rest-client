package ai.vital.agent.rest.model

class KGQuery extends KGRequest {

    String model_class = "KGQuery"

    String kgservice_query

    String segment_name = null

    static {
        registerType("KGQuery", KGQuery)
    }
}
