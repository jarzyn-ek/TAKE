/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.beans;

/**
 *
 * @author olunia
 */
public class ColorBean {
    
    private String foregroundColor;
    private String backgroundColor;
    private String borderVisible;
    
    
    public ColorBean() {
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the borderVisible
     */
    public String getBorderVisible() {
        return borderVisible;
    }

    /**
     * @param borderVisible the borderVisible to set
     */
    public void setBorderVisible(String borderVisible) {
        this.borderVisible = borderVisible;
    }
    
}
