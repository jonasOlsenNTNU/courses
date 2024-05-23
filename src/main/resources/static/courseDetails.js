
function loadData() {
    requestData("/courses/coursedetails" + window.location.search, showCourseDetails)
    /* requestData("/providerscourses" + window.location.search, showProviderDetails)*/
}
function showCourseDetails(course) {
    showCourse(course, "courseDetailsContainer");
}

function showCourse(course, containerElementId) {
    const courseContainer = document.getElementById(containerElementId);
    if (courseContainer) {
        removeAllChildren(courseContainer);
        courseContainer.appendChild(createCourseElement(course));
    }
}

function removeAllChildren(element) {
    element.innerText = "";
}

function createCourseElement(course) {
    const courseElement = document.createElement("div");
    courseElement.classList.add("courseDetails");
    const courseTitle = document.createElement("h1");
    courseTitle.innerHTML = course.title;
    courseElement.appendChild(courseTitle);
    const courseDescription = document.createElement("p");
    courseDescription.classList.add("courseDescription");
    courseDescription.innerHTML = course.description;
    courseElement.appendChild(courseDescription);
    const courseLevel = document.createElement("p");
    courseLevel.innerHTML = "Difficulty: " + course.level;
    courseElement.appendChild(courseLevel);
    const courseHours = document.createElement("p");
    courseHours.innerHTML = "Hours per week: " + course.hours;
    courseElement.appendChild(courseHours);
    const courseCredits = document.createElement("p");
    courseCredits.innerHTML = "ECTS Credits: " + course.credits;
    courseElement.appendChild(courseCredits);
    const courseCertification = document.createElement("p");
    courseCertification.innerHTML = "Certification: " + course.certification;
    courseElement.appendChild(courseCertification);




    return courseElement;
}

function showProviderDetails(providersCourses) {
    showProvider(providersCourses, "providerDetailsContainer")
}

function showProvider(providersCourses, containerElementId) {
    const providerContainer = document.getElementById(containerElementId);
    if (providerContainer) {
        removeAllChildren(providerContainer);
        providersCourses.forEach((providersCourses) => providerContainer.appendChild(createProviderElement(providersCourses)))
    }
}

function createProviderElement(providersCourses) {
    const providerElement = document.createElement("div");
    providerElement.classList.add("providerCourseDetails");
    providerElement.innerHTML = "<p>" + providersCourses.cost + "</p>"
}