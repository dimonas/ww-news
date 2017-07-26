import React from 'react';
import axiosApi from './utils/axios-api.js';
import Article from './Article.jsx';
import spinner from './spinner.gif';

class ArticleGrid extends React.Component {

	render() {
		const articleAction = this.props.selectArticleAction;
		return (
			<div>
        {this.props.articles.length > 0 &&
        <div className="articles-list">
        {this.props.articles.map(function(article, index) {
            return article.urlToImage != null ? <Article article={article} articleAction={articleAction} key={article.id}/> : '';
        })}
        </div>}
        {this.props.articles.length == 0 && <div className='waiting-spinner'><img width='100px' src={spinner} alt="Waiting..." /></div>}
			</div>
		);
	}
}

export default ArticleGrid;
