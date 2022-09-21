package syu.gs_up.web.controller.building.form;

import lombok.Data;

@Data
public class CreateBoardForm {

    private String bdTitle;

    private String bdContent;

    public String getTitle() {
        return bdTitle;
    }

    public String getContent() {
        return bdContent;
    }


    public void setTitle(String bdTitle) {
        this.bdTitle = bdTitle;
    }

    public void setContent(String bdContent) {
        this.bdContent = bdContent;
    }
}