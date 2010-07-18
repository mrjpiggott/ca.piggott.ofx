package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXCreditCardMsgSrsV1;
import ca.piggott.ofx.model.IOFXCreditCardStatementTransactionResponse;
import ca.piggott.ofx.parser.impl.OFXObject;

/**
 * CREDITCARDMSGSRSV1
 */
public class OFXCreditCardMsgSrsV1 implements OFXObject, IOFXCreditCardMsgSrsV1 {
	private IOFXCreditCardStatementTransactionResponse response;

	@Override
	public void addProperty(String tag, String item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof OFXCreditCardStatementTransactionResponse)
			response = (OFXCreditCardStatementTransactionResponse) obj;
		else 
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardMsgSrsV1#setResponse(ca.piggott.ofx.model.IOFXCreditCardStatementTransactionResponse)
	 */
	@Override
	public void setResponse(IOFXCreditCardStatementTransactionResponse response) {
		this.response = response;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXCreditCardMsgSrsV1#getResponse()
	 */
	@Override
	public IOFXCreditCardStatementTransactionResponse getResponse() {
		return response;
	}
}
