package processors;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Replacer {
    public File replace(Map<String, String> stringStringMap, String chatId, String fileName) throws Exception, IOException {
        XWPFDocument doc = new XWPFDocument(OPCPackage.open("C:\\dedText\\zrazok.docx"));

        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains(entry.getKey())) {
                            text = text.replace(entry.getKey(), entry.getValue());
                            r.setText(text, 0);
                        }
                    }
                }
            }
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null && text.contains(entry.getKey())) {
                                    text = text.replace(entry.getKey(), entry.getValue());
                                    r.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }
            doc.write(new FileOutputStream(fileName));
        }
        return new File(fileName);
    }
}
