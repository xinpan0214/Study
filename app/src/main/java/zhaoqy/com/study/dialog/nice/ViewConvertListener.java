package zhaoqy.com.study.dialog.nice;

import java.io.Serializable;

/**
 * Created by zhaoqy on 2017/9/6.
 */

public interface ViewConvertListener extends Serializable {

    long serialVersionUID = System.currentTimeMillis();

    void convertView(ViewHolder holder, BaseNiceDialog dialog);
}
