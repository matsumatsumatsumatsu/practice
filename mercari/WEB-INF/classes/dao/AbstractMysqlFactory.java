package dao;

import java.io.IOException;
import java.util.Properties;

import command.CommandFactory;

public abstract class AbstractMysqlFactory {
    public static AbstractMysqlFactory getFactory() {
        AbstractMysqlFactory factory = null;
        try {

        	Properties prop = new Properties();
        	prop.load(CommandFactory.class.getClassLoader().getResourceAsStream("property/dao.properties"));
			String name = prop.getProperty("dao");
			System.out.println(name);

//            // プロパティファイルを読み込む
//        	ResourceBundle rb = ResourceBundle.getBundle("property/dao");
//
//
//            // パスに対応した文字列を取得します
//            String name = rb.getString("dao");

            // 指定された名前のクラスに対応したClassクラスの
            // インスタンスを取得する（名前は完全限定名であること）
            Class c = Class.forName(name);

            // Classクラスのインスタンスを利用して
            // 対応するクラスのインスタンス化を行う
            factory = (AbstractMysqlFactory) c.newInstance();

        } catch (ClassNotFoundException e) {
            // 実際には独自例外にラップしてスローする
            throw new RuntimeException(e.getMessage(), e);
        } catch (InstantiationException e) {
            // 実際には独自例外にラップしてスローする
            throw new RuntimeException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            // 実際には独自例外にラップしてスローする
            throw new RuntimeException(e.getMessage(), e);
        } catch (IOException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}

        return factory;
    }
    public abstract UserInterfaceDao getUserInterfaceDao();
    public abstract ItemInterfaceDao getItemInterfaceDao();
}