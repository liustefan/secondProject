(function(H) {
    'use strict';
    var addEvent = H.addEvent,
        doc = document,
        body = doc.body
        // isMove = $("#btn_move").val();


    H.wrap(H.Chart.prototype, 'init', function(proceed) {

        // Run the original proceed method
        proceed.apply(this, Array.prototype.slice.call(arguments, 1));

        var chart = this,
            options = chart.options,
            panning = options.chart.panning || true,
            zoomType = options.chart.zoomType || '',
            container = chart.container,
            yAxis = chart.yAxis[0],
            xAxis = chart.xAxis[0],
            downYPixels,
            downXPixels,
            downYValue,
            downXValue,
            isDragging = false,
            hasDragged = 0,
            hasDraggedX = 0;

        
        if (panning) {

            addEvent(container, 'mousedown', function(e) {
                if (e[chart.options.chart.panKey + 'Key'] || $("#isMove").val() == 'true' && !H.Pointer.prototype.inClass(e.target, 'highcharts-scrollbar')) {
                	
                    body.style.cursor = 'pointer';
                    downYPixels = chart.pointer.normalize(e).chartY;
                    downXPixels = chart.pointer.normalize(e).chartX;
                    downYValue = yAxis.toValue(downYPixels);
                    downXValue= xAxis.toValue(downXPixels);
                    isDragging = true;
                }
            });

            addEvent(container, 'mousemove', function(e) {
                if (isDragging && !H.Pointer.prototype.inClass(e.target, 'highcharts-scrollbar')) { 
                    body.style.cursor = 'pointer';
//                    var dragYPixels = chart.pointer.normalize(e).chartY,
//                        dragYValue = yAxis.toValue(dragYPixels),
//
//                        yExtremes = yAxis.getExtremes(),
//                        yUserMin = yExtremes.userMin,
//                        yUserMax = yExtremes.userMax,
//                        yDataMin = yExtremes.dataMin,
//                        yDataMax = yExtremes.dataMax,
//
//                        yMin = yUserMin !== undefined ? yUserMin : yDataMin,
//                        yMax = yUserMax !== undefined ? yUserMax : yDataMax,
//
//                        newMinY,
//                        newMaxY;
                    
                    var dragXPixels = chart.pointer.normalize(e).chartX,
                    dragXValue = xAxis.toValue(dragXPixels),

                    xExtremes =xAxis.getExtremes(),
                    xUserMin = xExtremes.userMin,
                    xUserMax = xExtremes.userMax,
                    xDataMin = xExtremes.dataMin,
                    xDataMax = xExtremes.dataMax,

                    xMin = xUserMin !== undefined ? xUserMin : xDataMin,
                    xMax = xUserMax !== undefined ? xUserMax : xDataMax,

                    newMinX,
                    newMaxX;

                    // determine if the mouse has moved more than 10px
//                    hasDragged = Math.abs(downYPixels - dragYPixels);

                    hasDraggedX = Math.abs(downXPixels - dragXPixels);

//                    if (hasDragged > 10) {
//                    	
//                        newMinY = yMin - (dragYValue - downYValue);
//                        newMaxY = yMax - (dragYValue - downYValue);
////                        if(newMinY > yDataMin && newMaxY <yDataMax)
//                        yAxis.setExtremes(newMinY, newMaxY, true, false);
//                    }

                    if (hasDraggedX > 10 ) {

                        newMinX = xMin - (dragXValue - downXValue);
                        newMaxX = xMax - (dragXValue - downXValue);
                        if(newMinX > xDataMin && newMaxX <xDataMax)
                        	xAxis.setExtremes(newMinX <xDataMin?xDataMin:newMinX, newMaxX >xDataMax?xDataMax:newMaxX , true, false);
                    }
                }
            });

            addEvent(doc, 'mouseup', function() {
                if (isDragging) {
                    body.style.cursor = 'default';
                    isDragging = false;
                }
            });
        }
    });
}(Highcharts));
