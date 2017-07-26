var axios = require('axios');

const axiosApi = {

	get: function(uri, callback) {
		return axios.get(uri).then(callback);
	},

}

export default axiosApi;
