package moe.nea.jdwp.struct.virtualmachine

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.base.*

/**
 * Returns all threads currently running in the target VM . The returned list contains threads created through java.lang.Thread, all native threads attached to the target VM through JNI, and system threads created by the target VM. Threads that have not yet been started and threads that have completed their execution are not included in the returned list. 
 * [External](https://docs.oracle.com/en/java/javase/17/docs/specs/jdwp/jdwp-protocol.html#JDWP_VirtualMachine_AllThreads)
 */
class AllThreads : JDWPComposite(), JDWPCommandPayload<AllThreadsReply> {
    override val reply = AllThreadsReply()
    override val commandId: UByte get() = 4.toUByte()
    override val commandSetId: UByte get() = 1.toUByte()
}
/**
 * Reply for [AllThreads]
 */
class AllThreadsReply : JDWPComposite(), JDWPReplyPayload {
    /**
     * Number of threads that follow.
     */
    var threads by useField(JDWPInt())
    var threadsElements by useField(JDWPExternalVector(this::threads, ::AllThreadsReplyThreadsElement))
}


/**
 * Component for [AllThreadsReply]
 */
class AllThreadsReplyThreadsElement : JDWPComposite() {
    /**
     * A running thread
     */
    var thread by useField(JDWPThreadId())
}

