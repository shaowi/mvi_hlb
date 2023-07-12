package com.mvidyn.std.phub.ui.service;

import java.util.List;

import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;

public interface OnlineService {
	public OnlineCbftData createCbftTransaction(OnlineCbftForm form);

	public List<OnlineCbftForm> getCbftTransactionsByFilename(String filename);

	public List<OnlineCbftForm> getCbftTransactions();
}
