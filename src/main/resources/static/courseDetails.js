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

    requestData()

    return courseElement;
}
