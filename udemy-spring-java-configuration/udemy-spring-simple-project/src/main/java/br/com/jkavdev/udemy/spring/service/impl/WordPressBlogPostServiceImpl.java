package br.com.jkavdev.udemy.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.jkavdev.udemy.spring.domain.BlogPost;
import br.com.jkavdev.udemy.spring.service.BlogPostService;

public class WordPressBlogPostServiceImpl implements BlogPostService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("WordPress salvar post chamado......");
	}

}
