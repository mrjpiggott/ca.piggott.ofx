package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXCreditCardMsgSrsV1;
import ca.piggott.ofx.model.IOFXRoot;
import ca.piggott.ofx.model.IOFXBankingMessage;
import ca.piggott.ofx.model.IOFXSignOnMessageServiceV1;
import ca.piggott.ofx.parser.impl.OFXObject;


public class OFXRoot implements OFXObject, IOFXRoot {
	private IOFXSignOnMessageServiceV1 signOnMsg;
	private IOFXCreditCardMsgSrsV1 ccSignOnMsg;
	private IOFXBankingMessage bankingMsg;

	@Override
	public void addProperty(String tag, String item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof OFXSignOnMsgSrsV1)
			signOnMsg = (IOFXSignOnMessageServiceV1) obj;
		else if (obj instanceof OFXBankingMessage)
			bankingMsg = (IOFXBankingMessage) obj;
		else if (obj instanceof OFXCreditCardMsgSrsV1)
			ccSignOnMsg = (IOFXCreditCardMsgSrsV1) obj;
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFX#getBankingMsg()
	 */
	@Override
	public IOFXBankingMessage getBankingMsg() {
		return bankingMsg;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFX#getSignOnMsg()
	 */
	@Override
	public IOFXSignOnMessageServiceV1 getSignOnMsg() {
		return signOnMsg;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFX#setBankingMsg(ca.piggott.ofx.internal.model.OFXBankingMessage)
	 */
	@Override
	public void setBankingMsg(IOFXBankingMessage bankingMsg) {
		this.bankingMsg = bankingMsg;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFX#setSignOnMsg(ca.piggott.ofx.internal.model.OFXSignOnMsgSrsV1)
	 */
	@Override
	public void setSignOnMsg(IOFXSignOnMessageServiceV1 signOnMsg) {
		this.signOnMsg = signOnMsg;
	}

	public void setCcSignOnMsg(IOFXCreditCardMsgSrsV1 ccSignOnMsg) {
		this.ccSignOnMsg = ccSignOnMsg;
	}

	public IOFXCreditCardMsgSrsV1 getCcSignOnMsg() {
		return ccSignOnMsg;
	}
}
