package exception;

public class ApplicationException extends Exception{
	public ApplicationException(String mess,Throwable e){
		super(mess,e);
	}

	public ApplicationException(String mess){
		super(mess);
	}

	public ApplicationException(Throwable e){
		super(e);
	}

	public ApplicationException(){}

	public ApplicationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		//指定された詳細メッセージ、原因、抑制の有効化または無効化、書き込み可能スタックトレースの有効化または無効化に基づいて、新しい実行時例外を構築する
	}
}