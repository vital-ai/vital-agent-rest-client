package ai.vital.agent.rest.model

enum KGUpdateType {

    NONE,
    INSERT, // confirm URIs do not exist
    UPDATE, // confirm URIs exist
    UPSERT, // update or insert
    DELETE

}