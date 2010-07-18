package ca.piggott.ofx.model;

import java.math.BigDecimal;
import java.util.Date;

public interface IOFXBalance {

	public void setDate(Date date);

	public Date getDate();

	public void setBalance(BigDecimal balance);

	public BigDecimal getBalance();

}