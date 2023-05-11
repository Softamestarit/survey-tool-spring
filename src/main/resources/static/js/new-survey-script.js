window.addEventListener('beforeunload', function(event) {
  const confirmationMessage = "Are you sure?";
  event.returnValue = confirmationMessage;
  return confirmationMessage;
});

goBackButton.addEventListener('click', function() {
  window.history.back();
});