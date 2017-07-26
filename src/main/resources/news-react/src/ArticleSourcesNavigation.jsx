import React from 'react';
import axiosApi from './utils/axios-api.js';
import ArticleSource from './ArticleSource.jsx';

class ArticleSourcesNavigation extends React.Component {

constructor(props){
	super(props);
	this.state = {
      articleSources : [],
      activeSource: ''
  };
}

componentDidMount() {
  axiosApi.get(this.props.dataProvierUrl, function(response) {
    this.setState(
        function() {
          return {
            articleSources: response.data
          }
        }
    )}.bind(this)
  );
}

setActiveSource(source) {
  this.setState({activeSource: source})
}

	render() {
    const updateArticles4SourceAction = this.props.updateArticles4SourceAction;
    const activeSource = this.state.activeSource;
    const setActiveSource = this.setActiveSource.bind(this);
		return (
			<div>
        <ul className="nav nav-pills">
        {this.state.articleSources.map(function(articleSource, index) {
            return <ArticleSource active={activeSource == articleSource.id}
                                  articleSource={articleSource}
                                  updateArticles4SourceAction={updateArticles4SourceAction}
                                  setActiveSource={setActiveSource}
																	key={articleSource.id}/>
        })}
        </ul>
			</div>
		);
	}
}

export default ArticleSourcesNavigation;
