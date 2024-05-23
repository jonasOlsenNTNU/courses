
function showAllCourses(courses) {
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
    cardElement.classList.add("coursesCourseCard");
    const linkElement = document.createElement("a");
    linkElement.href ="/coursedetails?id=" + course.id;
    linkElement.innerHTML = "Details";
    cardElement.innerHTML =
        "<p>" + course.title + "<p/>";
    cardElement.appendChild(linkElement);
    return cardElement;
}

function redirectToDetailPage(id) {
    window.location.href = "/courses/" + id;
}