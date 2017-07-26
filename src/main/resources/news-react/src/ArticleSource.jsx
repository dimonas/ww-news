import React from 'react';

class ArticleSource extends React.Component {

	render() {
    const {articleSource} = this.props;
		return (
				<li role="presentation" className={this.props.active ? 'active' : ''}>
					<a href="#" onClick={()=> {
							this.props.updateArticles4SourceAction(articleSource.id)
							this.props.setActiveSource(articleSource.id);
						}}

						>{articleSource.name}</a>
				</li>
		);
	}
}

export default ArticleSource;
