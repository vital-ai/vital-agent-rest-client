package ai.vital.agent.rest.model

enum KGStatusCode {

    OK(0)

    final int code

    private KGStatusCode(int code) {
        this.code = code
    }

    int getCode() {
        return code
    }

    static KGStatusCode fromCode(int code) {
        values().find { it.code == code }
    }

}