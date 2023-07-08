package moe.nea.jdwp.struct.referencetype

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.struct.base.*

/**
 * Returns the value of the SourceDebugExtension attribute. Since JDWP version 1.4. Requires canGetSourceDebugExtension capability - see .
 */
class SourceDebugExtension : JDWPComposite(), JDWPCommandPayload<SourceDebugExtensionReply> {
    /**
     * The reference type ID.
     */
    var refType by useField(JDWPReferenceTypeId())
    override val reply = SourceDebugExtensionReply()
    override val commandId: UByte get() = 12.toUByte()
    override val commandSetId: UByte get() = 2.toUByte()
}
/**
 * Reply for [SourceDebugExtension]
 */
class SourceDebugExtensionReply : JDWPComposite(), JDWPReplyPayload {
    /**
     * extension attribute
     */
    var extension by useField(JDWPString())
}

