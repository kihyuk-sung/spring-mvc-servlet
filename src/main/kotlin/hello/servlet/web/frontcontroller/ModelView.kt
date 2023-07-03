package hello.servlet.web.frontcontroller

class ModelView(
    val viewName: String,
    val model: Map<String, Any> = emptyMap(),
)
