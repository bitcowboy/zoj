/*
 * Copyright 2007 Zhang, Zheng <oldbig@gmail.com>
 * 
 * This file is part of ZOJ.
 * 
 * ZOJ is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation; either revision 3 of the License, or (at your option) any later revision.
 * 
 * ZOJ is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with ZOJ. if not, see
 * <http://www.gnu.org/licenses/>.
 */

package cn.edu.zju.acm.onlinejudge.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * <p>
 * ContestForm.
 * </p>
 * 
 * @author Zhang, Zheng
 * @version 2.0
 */
public class LimitForm extends ActionForm implements Serializable {

    /**
     * The id.
     */
    private String id = null;

    /**
     * The timeLimit.
     */
    private String timeLimit = null;

    /**
     * The MemoryLimit.
     */
    private String memoryLimit = null;

    /**
     * The outputLimit.
     */
    private String outputLimit = null;

    /**
     * The submissionLimit.
     */
    private String submissionLimit = null;

    /**
     * Empty constructor.
     */
    public LimitForm() {
    // Empty constructor
    }

    /**
     * Sets the id.
     * 
     * @prama id the id to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the id.
     * 
     * @return the id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets the timeLimit.
     * 
     * @prama timeLimit the timeLimit to set.
     */
    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    /**
     * Gets the timeLimit.
     * 
     * @return the timeLimit.
     */
    public String getTimeLimit() {
        return this.timeLimit;
    }

    /**
     * Sets the MemoryLimit.
     * 
     * @prama memoryLimit the MemoryLimit to set.
     */
    public void setMemoryLimit(String memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    /**
     * Gets the MemoryLimit.
     * 
     * @return the MemoryLimit.
     */
    public String getMemoryLimit() {
        return this.memoryLimit;
    }

    /**
     * Sets the outputLimit.
     * 
     * @prama outputLimit the outputLimit to set.
     */
    public void setOutputLimit(String outputLimit) {
        this.outputLimit = outputLimit;
    }

    /**
     * Gets the outputLimit.
     * 
     * @return the outputLimit.
     */
    public String getOutputLimit() {
        return this.outputLimit;
    }

    /**
     * Sets the submissionLimit.
     * 
     * @prama submissionLimit the submissionLimit to set.
     */
    public void setSubmissionLimit(String submissionLimit) {
        this.submissionLimit = submissionLimit;
    }

    /**
     * Gets the submissionLimit.
     * 
     * @return the submissionLimit.
     */
    public String getSubmissionLimit() {
        return this.submissionLimit;
    }

    /**
     * Validates the form.
     * 
     * @param mapping
     *            the action mapping.
     * @param request
     *            the user request.
     * 
     * @return collection of validation errors.
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        if (this.id == null) {
            return null;
        }
        ActionErrors errors = new ActionErrors();
        this.checkInteger(this.timeLimit, 0, 3600, "timeLimit", errors);
        this.checkInteger(this.memoryLimit, 0, 1024 * 1024, "memoryLimit", errors);
        this.checkInteger(this.outputLimit, 0, 128 * 1024, "outputLimit", errors);
        this.checkInteger(this.submissionLimit, 0, 16 * 1024, "submissionLimit", errors);
        return errors;
    }

    /**
     * 
     * @param value
     * @param min
     * @param max
     * @param name
     * @param errors
     */
    private void checkInteger(String value, int min, int max, String name, ActionErrors errors) {
        if (value == null || value.trim().length() == 0) {
            errors.add(name, new ActionMessage("LimitForm." + name + ".required"));
            return;
        }
        try {
            int intValue = Integer.parseInt(value);
            if (intValue < min || intValue > max) {
                errors.add(name, new ActionMessage("LimitForm." + name + ".outrange"));
            }
        } catch (NumberFormatException e) {
            errors.add(name, new ActionMessage("LimitForm." + name + ".invalid"));
        }
    }

}
