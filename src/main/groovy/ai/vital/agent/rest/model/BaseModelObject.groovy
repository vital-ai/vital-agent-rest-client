package ai.vital.agent.rest.model

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

abstract class BaseModelObject {

    String model_class = "BaseModelObject"

    private static final Map<String,Class<? extends BaseModelObject>> REGISTRY = [:]

    static void registerType(String key, Class<? extends BaseModelObject> cls) {
        REGISTRY[key] = cls
    }

    static BaseModelObject fromJson(String json) {
        def slurper = new JsonSlurper()
        Map data = slurper.parseText(json) as Map
        String type = data.get('model_class')

        String fqcn = "${BaseModelObject.package.name}.${type}"

        try {
            Class.forName(fqcn)
        } catch (ClassNotFoundException ignored) {}

        Class<? extends BaseModelObject> cls = REGISTRY[type]

        if (!cls) {
            throw new IllegalArgumentException("Unknown model_class: $type")
        }

        println("Instantiating: ${cls.name} with: ${data}")

        return cls.newInstance(data)
    }


    String toJson(boolean pretty = false) {

        def obj = this

        def slurper = new JsonSlurper()

        Map data = obj.properties.findAll { key, val ->
            !['class','metaClass'].contains(key) && val != null
        }

        data = data.collectEntries { k,v ->
            if (v instanceof BaseModelObject) {
                [ (k): slurper.parseText(v.toJson()) ]
            } else {
                [ (k): v ]
            }
        }

        data.model_class = obj.model_class

        String raw = JsonOutput.toJson(data)

        String output = pretty ? JsonOutput.prettyPrint(raw) : raw

        return output
    }

    @Override
    String toString() {
        this.toJson()
    }
}
