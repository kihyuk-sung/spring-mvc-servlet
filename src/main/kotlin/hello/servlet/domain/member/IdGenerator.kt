package hello.servlet.domain.member

object IdGenerator{
    private var sequence = 0L
    fun next(): Long = ++sequence
}
