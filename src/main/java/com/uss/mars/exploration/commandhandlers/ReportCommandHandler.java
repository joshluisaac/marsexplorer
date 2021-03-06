package com.uss.mars.exploration.commandhandlers;

import com.uss.mars.exploration.ITableTop;
import com.uss.mars.exploration.services.CommandQueueService;
import com.uss.mars.exploration.TableTop;
import com.uss.mars.exploration.TableTopOccupant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * An implementation of {@link CommandHandler} that handles all <tt>REPORT</tt>
 * command requests in {@link CommandQueueService#queue}
 */

public class ReportCommandHandler implements CommandHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ReportCommandHandler.class);
    private final ITableTop tableTop;

    public ReportCommandHandler(ITableTop tableTop) {
        this.tableTop = tableTop;
    }

    /**
     * Report the state of the tabletop/grid and format output.
     * It does this by reading the index and formatting the result rather than
     * traversing the entire matrix structure.
     */
    @Override
    public void execute() {
        StringBuilder buff = new StringBuilder();
        StringBuilder blockBuilder = new StringBuilder();
        buff.append("E:");
        blockBuilder.append("B:");
        for (TableTopOccupant occupant : tableTop.getMatrixIndex()) {
            String code = occupant.getOccupantType().getCode();
            int xAxis = occupant.getCoordinate().getCoordinateX();
            int yAxis = occupant.getCoordinate().getCoordinateY();
            if (code.equals("E")) {
                String formattedText = MessageFormat.format("({0},{1})",xAxis,yAxis);
                buff.append(formattedText + " ");
            }
            if (code.equals("B")) {
                String formattedText = MessageFormat.format("({0},{1})",xAxis,yAxis);
                blockBuilder.append(formattedText + " ");
            }

        }
        LOG.info("RESULT: {}{}",buff.toString(),blockBuilder.toString());
        System.out.println(buff.toString()+""+blockBuilder.toString());

    }

}
