package command;

import context.ResponseContext;

public class ForwardWithdrawCommand extends AbstractCommand{
	public ResponseContext execute(ResponseContext resc){
		resc.setTarget("withdraw");
		return resc;
	}
}