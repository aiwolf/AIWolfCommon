package org.aiwolf.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Create Logger
 * @author tori
 *
 */
public class AiWolfLoggerFactory {
	
    protected static final String LOGGING_PROPERTIES = "javalog.properties";

    /**
     * 
     * @param name
     * @return
     */
	static public Logger getSimpleLogger(String name){
		Logger logger = Logger.getLogger(name);
		
	      // クラスパスの中から ログ設定プロパティファイルを取得
        final InputStream inStream = AiWolfLoggerFactory.class.getClassLoader().getResourceAsStream(LOGGING_PROPERTIES);
        if (inStream == null) {
            logger.info("ログ設定: " + LOGGING_PROPERTIES + " はクラスパス上に見つかりませんでした。");
        } else {
            try {
                LogManager.getLogManager().readConfiguration(inStream);
                logger.config("ログ設定: LogManagerを設定しました。");
            } catch (IOException e) {
                logger.warning("ログ設定: LogManager設定の際に"
                    +"例外が発生しました。:"+ e.toString());
            } finally {
                try {
                    if (inStream != null) inStream.close(); 
                } catch (IOException e) {
                    logger.warning("ログ設定: ログ設定プロパティ"
                        +"ファイルのストリームクローズ時に例外が"
                        +"発生しました。:"+ e.toString());
                }
            }
        }
		return logger;
	}
	
	/**
	 * 
	 * @param name
	 * @param outputFile
	 * @return
	 * @throws IOException
	 */
	static public Logger getServerLogger(String name, File outputFile) throws IOException{
		Logger logger = Logger.getLogger(name);
		
		FileOutputStream out = new FileOutputStream(outputFile);
		Handler handler = new StreamHandler(out, new ServerLogFormat(true));
		logger.addHandler(handler);
		return logger;
	}
	
	/**
	 * ゲーム用ログを獲得
	 * @param outputFile
	 * @return
	 * @throws IOException
	 */
	static public Logger getGameLogger(File outputFile) throws IOException{
		Logger logger = getSimpleLogger("Game");

		outputFile.getParentFile().mkdirs();
		FileOutputStream out = new FileOutputStream(outputFile);
		Handler handler = new StreamHandler(out, new GameLogFormat());
		logger.addHandler(handler);
		logger.setLevel(Level.INFO);
		return logger;
	}

}
