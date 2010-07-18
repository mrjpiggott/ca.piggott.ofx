package ca.piggott.ofx.internal.model;

import ca.piggott.ofx.model.IOFXBankingMessage;
import ca.piggott.ofx.model.IOFXStatementTransactionResponse;
import ca.piggott.ofx.parser.impl.OFXObject;

/**
 * BANKMSGSRSV1
 */
public class OFXBankingMessage implements OFXObject, IOFXBankingMessage {
	private IOFXStatementTransactionResponse resp;

	@Override
	public void addProperty(String tag, String item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addObject(OFXObject obj) {
		if (obj instanceof OFXStatementTransactionResponse)
			resp = (IOFXStatementTransactionResponse) obj;
		else
			throw new IllegalArgumentException();
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankingMessage#setResp(ca.piggott.ofx.internal.model.OFXStatementTransactionResponse)
	 */
	@Override
	public void setResp(IOFXStatementTransactionResponse resp) {
		this.resp = resp;
	}

	/* (non-Javadoc)
	 * @see ca.piggott.ofx.internal.model.IOFXBankingMessage#getResp()
	 */
	@Override
	public IOFXStatementTransactionResponse getResp() {
		return resp;
	}
	
}
