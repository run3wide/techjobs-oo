package org.launchcode.controllers;

import org.launchcode.models.*;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        Job job = jobData.findById(id);
        model.addAttribute("job", job);

        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        if (errors.hasErrors()) {
            return "new-job";
        } else {
            Employer employer = jobData.getEmployers().findById(jobForm.getEmployerId());
            Location location = jobData.getLocations().findById(jobForm.getLocationId());
            CoreCompetency coreCompetency = jobData.getCoreCompetencies().findById(jobForm.getCoreCompetencyId());
            PositionType positionType = jobData.getPositionTypes().findById(jobForm.getPositionTypeId());
            String name = jobForm.getName();

            Job job = new Job()
                    .setName(name)
                    .setEmployer(employer)
                    .setCoreCompetency(coreCompetency)
                    .setLocation(location)
                    .setPositionType(positionType);

            jobData.add(job);

            return "redirect:?id=" + job.getId();
        }

    }
}
