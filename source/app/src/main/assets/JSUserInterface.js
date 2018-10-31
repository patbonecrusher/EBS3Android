console.log("here");
console.error("booboo");
buildUI = function() {

    templateSV = {
        tabName: "Templates",
        tableView: {title: "Templates",   data: templates,   cellFieldName: "TemplateName",  buttons:"Edit, +"},
        formView:  {title: "Template details", xml: "TemplateForm", buttons: ",Edit"}
    };

    projectSV = {
        tabName: "Projects",
        tableView: {title: "Projects",   data: projects,     cellFieldName: "ProjectName",   buttons:"Edit, +"},
        formView:  {title: "Project details",  xml: "MTEProjectForm", buttons: ",Edit"}
    };

    inspectionSV = {
        tabName: "Inspections",
        tableView: {title: "Inspections", data: inspections, cellFieldName: "InspectionNumber", buttons:"Edit, +"},
        formView:  {title: "Inspection details",  xml: "InspectionForm", buttons: ",Edit"}
    };

    photoSV = {
        tabName: "Photos",
        tableView: {title: "Photos",      data: photos,      cellFieldName: "PhotoNumber",    buttons:"Edit, +"},
        formView:  {title: "Photo details",    xml: "PhotoForm", buttons: ",Edit"}
    };


    var obj = [templateSV, projectSV, inspectionSV, photoSV];
    activeTabName = "Templates";

    EBUIBuilder.buildUI(obj);
};
