import React from 'react';

const VisibilityWrapper = React.createClass({
	render() {
		return (
      <div>
        {this.props.visible && this.props.children}
      </div>
    )
	}
});

export default VisibilityWrapper;
