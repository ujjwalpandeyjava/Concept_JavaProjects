# Ways to get the data from client..



## @RequestBody
	public Map<String, Object> deleteQuery(@Valid @RequestBody(required = true) DeleteBody deleteBody) {
	Useful in 90% of cases.


## 	@RequestParam
	@GetMapping public Page<CustomerQueryEntity> getQueryPaginated(@RequestParam("pageNo") int pageNo,
			@RequestParam("pageSize") int pageSize, @RequestParam("sort") int sort,
			@RequestParam("sortByKey") String sortByKey) {
	have to use for every parameter with type id getting a array [] have to pass same parameter in the url form the server.

## 	@ModelAttribute
	public ResponseEntity<Map<String, Object>> saveQuery(@Valid @ModelAttribute CustomerQueryEntityModel body) {
	Collect all the params in class like the requestBody..

