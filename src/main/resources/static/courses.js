
function showAllCourses() {
    showCourseCard(courses, "allCoursesContainer");
}

function showCourseCard(courses, containerElementId) {
    const courseContainer = document.getElementById(containerElementId);
    if (courseContainer) {
        removeAllChildren(courseContainer);
        courses.forEach((course) => courseContainer.appendChild(createCardElement(course)))
    }
}
function removeAllChildren(element) {
    element.innerText = "";
}

function createCardElement(course) {
    const cardElement = document.createElement("div");
    cardElement.classList.add("card");
    cardElement.innerHTML =
        "<p>" +
        course.title +
        "</p>";
    return cardElement;
}