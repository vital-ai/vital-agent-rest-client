package ai.vital.agent.rest.model

class KGModification extends BaseModelObject {

    String model_class = "KGModification"

    int kg_objects_inserted = 0
    int kg_objects_updated = 0
    int kg_objects_upserted = 0
    int kg_objects_deleted = 0

    double duration_ms = 0

    static {
        registerType("KGModification", KGModification)
    }

}
