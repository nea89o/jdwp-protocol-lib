package moe.nea.jdwp.struct.virtualmachine

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.struct.base.*

/**
 * Returns reference types for all classes currently loaded by the target VM. See .
 */
class AllClasses : JDWPComposite(), JDWPCommandPayload<AllClassesReply> {
    override val reply = AllClassesReply()
    override val commandId: UByte get() = 3.toUByte()
    override val commandSetId: UByte get() = 1.toUByte()
}
/**
 * Reply for [AllClasses]
 */
class AllClassesReply : JDWPComposite(), JDWPReplyPayload {
    /**
     * Number of reference types that follow.
     */
    var classes by useField(JDWPInt())
    var classesElements by useField(JDWPExternalVector(this::classes, ::AllClassesClassesElement))
}


class AllClassesClassesElement : JDWPComposite() {
    /**
     * Kind of following reference type.
     */
    var refTypeTag by useField(JDWPByte())
    /**
     * Loaded reference type
     */
    var typeID by useField(JDWPReferenceTypeId())
    /**
     * The JNI signature of the loaded reference type
     */
    var signature by useField(JDWPString())
    /**
     * The current class status.
     */
    var status by useField(JDWPInt())
}



