package moe.nea.jdwp.struct.method

import moe.nea.jdwp.*
import moe.nea.jdwp.primitives.*
import moe.nea.jdwp.base.*

/**
 * Returns variable information for the method, including generic signatures for the variables. The variable table includes arguments and locals declared within the method. For instance methods, the "this" reference is included in the table. Also, synthetic variables may be present. Generic signatures are described in the signature attribute section in . Since JDWP version 1.5.
 * [External](https://docs.oracle.com/en/java/javase/17/docs/specs/jdwp/jdwp-protocol.html#JDWP_Method_VariableTableWithGeneric)
 */
class VariableTableWithGeneric : JDWPComposite(), JDWPCommandPayload<VariableTableWithGenericReply> {
    /**
     * The class.
     */
    var refType by useField(JDWPReferenceTypeId())
    /**
     * The method.
     */
    var methodID by useField(JDWPMethodId())
    override val reply = VariableTableWithGenericReply()
    override val commandId: UByte get() = 5.toUByte()
    override val commandSetId: UByte get() = 6.toUByte()
}
/**
 * Reply for [VariableTableWithGeneric]
 */
class VariableTableWithGenericReply : JDWPComposite(), JDWPReplyPayload {
    /**
     * The number of words in the frame used by arguments. Eight-byte arguments use two words; all others use one.
     */
    var argCnt by useField(JDWPInt())
    /**
     * The number of variables.
     */
    var slots by useField(JDWPInt())
    var slotsElements by useField(JDWPExternalVector(this::slots, ::VariableTableWithGenericReplySlotsElement))
}





/**
 * Component for [VariableTableWithGenericReply]
 */
class VariableTableWithGenericReplySlotsElement : JDWPComposite() {
    /**
     * First code index at which the variable is visible (unsigned). Used in conjunction with length. The variable can be get or set only when the current codeIndex <= current frame code index < codeIndex + length
     */
    var codeIndex by useField(JDWPLong())
    /**
     * The variable's name.
     */
    var name by useField(JDWPString())
    /**
     * The variable type's JNI signature.
     */
    var signature by useField(JDWPString())
    /**
     * The variable type's generic signature or an empty string if there is none.
     */
    var genericSignature by useField(JDWPString())
    /**
     * Unsigned value used in conjunction with codeIndex. The variable can be get or set only when the current codeIndex <= current frame code index < code index + length
     */
    var length by useField(JDWPInt())
    /**
     * The local variable's index in its frame
     */
    var slot by useField(JDWPInt())
}






