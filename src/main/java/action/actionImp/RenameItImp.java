package action.actionImp;

import action.RenameIt;
import org.apache.log4j.Logger;

import java.io.File;

public class RenameItImp implements RenameIt {

    private static Logger logger = Logger.getLogger(RenameIt.class);

    @Override
    public void traverseFolder(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                if(logger.isDebugEnabled()){
                    logger.debug("文件夹是空的!");
                }
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        if(logger.isDebugEnabled()){
                            logger.debug("文件夹:" + file2.getAbsolutePath());
                        }
                        traverseFolder(file2.getAbsolutePath());

                    } else {
                        if(logger.isDebugEnabled()){
                            logger.debug("文件:" + file2.getAbsolutePath());
                        }

                    }
                }
            }
        } else {
            if(logger.isDebugEnabled()){
                logger.debug("文件不存在!");
            }
        }
    }
}
