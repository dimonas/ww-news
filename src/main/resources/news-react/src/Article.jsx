import React from 'react';

class Article extends React.Component {

	render() {
    const {article, articleAction, articleClassName} = this.props;
		return (
      <div className={articleClassName == null ? "article-item" : articleClassName} onClick={() => articleAction(article)}>
        <div className="panel panel-default">
          <div className="panel-body">
            <div className="article-title">{article.title}</div>
            <div className="thumbnail">
              <img src={article.urlToImage} alt={article.title}/>
            </div>
            <div className="article-description">{article.description}</div>
            <div className="article-additional-info">{article.creationDate}</div>
          </div>
        </div>
      </div>
		);
	}
}

export default Article;
