/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.primefaces3.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author olunia
 */
@ManagedBean(name="lineChart")
public class LineChart {
    
    private LineChartModel lineChartModel;
    
    @PostConstruct
    public void init() 
    {
        createLineModels();
    }

    /**
     * @return the lineChartModel
     */
    public LineChartModel getLineChartModel() {
        return lineChartModel;
    }

    /**
     * @param lineChartModel the lineChartModel to set
     */
    public void setLineChartModel(LineChartModel lineChartModel) {
        this.lineChartModel = lineChartModel;
    }


    private void createLineModels() {
        createLineModel();
    }
    
    private void createLineModel() {
        this.lineChartModel = initLineModel();
    }
   
    
    private LineChartModel initLineModel() {
        
        LineChartModel model = new LineChartModel();
        
        LineChartSeries sinus = new LineChartSeries();
        sinus.setLabel("sinus");
        
        for (int i=0; i < 360; i+=10) {
            sinus.set(i, Math.sin(Math.toRadians(i)));
        }
        
        LineChartSeries cosinus = new LineChartSeries();
        cosinus.setLabel("cosinus");
        for (int i=0; i < 360; i+=10) {
            cosinus.set(i, Math.cos(Math.toRadians(i)));
        }
        
        model.addSeries(sinus);
        model.addSeries(cosinus);
        
        model.setZoom(true);
        
        return model;
        
    }
    
    
    
}
