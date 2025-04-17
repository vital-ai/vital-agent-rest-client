package ai.vital.agent.rest.model

class KGResponse extends BaseModelObject{

    String model_class = "KGResponse"

    KGStatusType status_type = KGStatusType.OK

    KGStatusCode status_code = KGStatusCode.OK

    KGResponseType response_type = KGResponseType.STATUS

    KGModification modification = new KGModification()

    String response_description = ""

    static {
        registerType("KGResponse", KGResponse)
    }

    KGGraphObjectList object_list = new KGGraphObjectList()

    KGResultList result_list = new KGResultList()

    KGSolutionList solution_list = new KGSolutionList()

}
