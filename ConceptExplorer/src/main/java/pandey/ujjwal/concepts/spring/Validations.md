# Ways to validate data before getting into the method and provide a response

## @Valid
	public ResponseEntity<String> verifyOTPForRegistration(@Valid @RequestBody UserRegistration userReg) {

## @Validation
	public String stepOne(@Validated(UserAccount.ValidationStepOne.class) @ModelAttribute("useraccount") UserAccount useraccount, BindingResult result) {
	
