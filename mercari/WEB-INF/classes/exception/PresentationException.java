package exception;

public class PresentationException extends ApplicationException{
	public PresentationException(String mess,Throwable e){
		super(mess,e);
	}

	public PresentationException(String mess){
		super(mess);
	}

	public PresentationException(Throwable e){
		super(e);
	}

	public PresentationException(){}

	public PresentationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		//指定された詳細メッセージ、原因、抑制の有効化または無効化、書き込み可能スタックトレースの有効化または無効化に基づいて、新しい実行時例外を構築する
	}
}
